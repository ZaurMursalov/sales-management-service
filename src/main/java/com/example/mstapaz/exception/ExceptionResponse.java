package com.example.mstapaz.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExceptionResponse {
   private String timestamp;
   private int status;
   private String error;
   private String message;
   private String path;

   public ExceptionResponse(int status, String error, String message, String path) {
      this.timestamp = java.time.LocalDateTime.now().toString();
      this.status = status;
      this.error = error;
      this.message = message;
      this.path = path;
   }

}
