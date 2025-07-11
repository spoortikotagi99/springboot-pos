package model.dto;

import java.util.ArrayList;
import java.util.List;

public class Response {
    public List<Message> messagesList;
    private boolean success;

    public Response() {
        this.messagesList = new ArrayList<>();
        this.success = true;
    }

    private boolean hasError() {
        for (Message m : messagesList) {
            if (m.type == MessageType.Error || m.type == MessageType.Exception) {
                return true;
            }
        }
        return false;
    }

    public String getErrorMessages() {
        StringBuilder sb = new StringBuilder();
        for (Message m : messagesList) {
            if (m.type == MessageType.Error || m.type == MessageType.Exception) {
                if (sb.length() > 0) sb.append(",\n");
                sb.append(m.message);
            }
        }
        return sb.toString();
    }

    public String getInfoMessages() {
        StringBuilder sb = new StringBuilder();
        for (Message m : messagesList) {
            if (m.type == MessageType.Information) {
                if (sb.length() > 0) sb.append(",\n");
                sb.append(m.message);
            }
        }
        return sb.toString();
    }

    public boolean isSuccessfull() {
        return !hasError(); // This ensures it correctly reflects errors
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    // **Corrected addError method**
    public void addError(String errorMessage) {
        this.messagesList.add(new Message(errorMessage, MessageType.Exception));
        this.success = false;
    }

    public List<Message> getMessagesList() {
        return messagesList;
    }
}
