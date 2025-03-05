package com.pocv01.DTO;

public class UserFilterDTO {
	private String isActive;  // Active or Inactive status
    private String userId;    // Optional userId filter

    // Getters and Setters
    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
