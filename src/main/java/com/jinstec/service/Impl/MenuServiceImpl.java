package com.jinstec.service.Impl;

import com.jinstec.dao.MenuMapper;
import com.jinstec.entity.Account;
import com.jinstec.entity.Menu;
import com.jinstec.service.AccountService;
import com.jinstec.service.MenuRoleService;
import com.jinstec.service.MenuService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jins
 * @date on 2018/4/25.
 */
@Service("menuServiceImpl")
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private MenuRoleService menuRoleService;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public String findAllMenu() {
        Account account = accountService.findById("2c90e79c62b397490162b397e9c20003");
        String roleId = account.getRoleId();
        List<String> menuIds = menuRoleService.findByRoleId(roleId);
        List<Menu> menuList = new ArrayList<>();
        Menu menu = null;
        for (String menuId : menuIds){
            menu = menuMapper.selectByPrimaryKey(menuId);
            menuList.add(menu);
        }
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        menuList.forEach(menu1 -> {
                JSONObject object = setMenu(menu1);
                jsonArray.put(object);
        });
        jsonObject.put("menu",jsonArray);
        return jsonObject.toString();
    }

    private JSONObject setMenu(Menu menu) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",menu.getId());
        jsonObject.put("name", menu.getName());
        jsonObject.put("url", menu.getUrl());
        jsonObject.put("logo","");
        return jsonObject;
    }

}
