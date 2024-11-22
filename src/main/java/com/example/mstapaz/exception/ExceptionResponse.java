package com.example.mstapaz.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExceptionResponse {
   private String timestamp;  // Timestamp
   private int status;        // HTTP status kodu
   private String error;      // Xəta tipi
   private String message;    // Xəta mesajı
   private String path;       // Endpoint path-i

   public ExceptionResponse(int status, String error, String message, String path) {
      this.timestamp = java.time.LocalDateTime.now().toString(); // ISO formatında zaman
      this.status = status;
      this.error = error;
      this.message = message;
      this.path = path;
   }

   // Getter və setter metodları
   public String getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(String timestamp) {
      this.timestamp = timestamp;
   }

   public int getStatus() {
      return status;
   }

   public void setStatus(int status) {
      this.status = status;
   }

   public String getError() {
      return error;
   }

   public void setError(String error) {
      this.error = error;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public String getPath() {
      return path;
   }

   public void setPath(String path) {
      this.path = path;
   }
}
