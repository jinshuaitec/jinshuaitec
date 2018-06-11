package com.jinstec.controller;

import com.jinstec.util.StringUtil;
import com.jinstec.util.datatable.DataRequest;
import com.jinstec.util.datatable.DataResult;
import com.jinstec.util.datatable.DataTableUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jins
 * @date on 2018/5/26.
 */
public class BaseController {

    public DataRequest params(HttpServletRequest request){
        DataRequest dataRequest = DataTableUtil.trans(request);
        String search = request.getParameter("search");
        if (StringUtil.isNotEmpty(search)){
            Map<String,Object> map = new HashMap<>();
            map.put("search",search);
            dataRequest.setParams(map);
        }
        return dataRequest;
    }
}
