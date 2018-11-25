package com.example.christian.adminsportec;

import android.app.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrofitError {
    @SerializedName("messages")
    @Expose
    private Notification.MessagingStyle.Message messages;

    public Notification.MessagingStyle.Message getMessages() {
        return messages;
    }

    public void setMessages(Notification.MessagingStyle.Message messages) {
        this.messages = messages;
    }
}