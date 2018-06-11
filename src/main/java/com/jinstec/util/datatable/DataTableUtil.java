package com.jinstec.util.datatable;

import com.jinstec.constant.Constant;
import com.jinstec.util.StringUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
/**
 * datatable工具类
 *
 * @author
 */
public class DataTableUtil {

    public static DataRequest trans(HttpServletRequest request) {
        DataRequest dataRequest = new DataRequest();
        Integer iDisplayStart = 0;
        String iDisplayStartStr = request.getParameter("iDisplayStart");
        if (StringUtil.isNotEmpty(iDisplayStartStr)) {
            iDisplayStart = Integer.valueOf(iDisplayStartStr);
        }
        Integer iDisplayLength = Constant.DEFAULT_PAGE_SIZE;
        String iDisplayLengthStr = request.getParameter("iDisplayLength");
        if (StringUtil.isNotEmpty(iDisplayLengthStr)) {
            iDisplayLength = Integer.valueOf(iDisplayLengthStr);
        }
        String iSortCol = request.getParameter("iSortCol_0");
        if ("0".equalsIgnoreCase(iSortCol)) {
            dataRequest.setOrder(Constant.DEFAULT_SORT_FIELD);
        } else {
            String columnName = request.getParameter("mDataProp_" + iSortCol);
            dataRequest.setOrder(columnName);
        }
        String sort = request.getParameter("sSortDir_0");
        Integer page = iDisplayStart / iDisplayLength;
        dataRequest.setPageIndex(page + 1);
        dataRequest.setPageSize(iDisplayLength);
        dataRequest.setSort(sort);
        return dataRequest;
    }

    public static String transToJsonStr(DataResult dro) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sEcho", dro.getsEcho());
        jsonObject.put("iTotalRecords", dro.getiTotalRecords());
        jsonObject.put("iTotalDisplayRecords", dro.getiTotalDisplayRecords());
        jsonObject.put("aaData", dro.getAaData());
        return jsonObject.toString();
    }

    /**
     * 传入AoColumn列名转换成json字符串
     * @return jsonStr
     */
    public static String getAoColumnsJsonString(String[] columns){
        JSONArray jsonArray = new JSONArray();
        for(String str :columns){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("mData",str);
            jsonArray.put(jsonObject);
        }
        return  jsonArray.toString();
    }
}
