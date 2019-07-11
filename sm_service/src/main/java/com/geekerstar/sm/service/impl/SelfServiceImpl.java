package com.geekerstar.sm.service.impl;

import com.geekerstar.sm.dao.SelfDao;
import com.geekerstar.sm.dao.StaffDao;
import com.geekerstar.sm.entity.Staff;
import com.geekerstar.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("selfService")
public class SelfServiceImpl implements SelfService {
    @Autowired
    private SelfDao selfDao;
    @Autowired
    private StaffDao staffDao;

    public Staff login(String account, String password) {
        Staff staff = selfDao.selectByAccount(account);
        if (staff == null) return null;
        if (staff.getPassword().equals(password)) return staff;
        return null;
    }

    public void changePassword(Integer id, String password) {
        Staff staff = staffDao.selectById(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }
}
