package com.company.project.jgroups;

import org.jgroups.JChannel;
import org.jgroups.Message;

/**
 * 组播通道
 *
 * @author wangzhj
 */
public class MChannel {

    private JChannel chanel;

    /**
     * 启动
     */
    public void start() {
        try {
            chanel = new JChannel();
            chanel.setName("")
                    .setReceiver(null)
                    .setDiscardOwnMessages(false)
                    .connect("");
        } catch (Exception ex) {

        }
    }

    /**
     * 停止
     */
    public void stop() {
        if (chanel != null) {
            chanel.close();
        }
    }


    /**
     * 发送消息
     *
     * @param mmsg 组播消息
     */
    public void send(MMessage mmsg) {
        try {
            Message msg = new Message(null, mmsg);
            chanel.send(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
