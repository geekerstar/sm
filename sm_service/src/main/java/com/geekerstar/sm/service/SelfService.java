package com.geekerstar.sm.service;

import com.geekerstar.sm.entity.Staff;

public interface SelfService {
    Staff login(String account, String password);
    void changePassword(Integer id, String password);
}
