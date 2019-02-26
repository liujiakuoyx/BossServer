package com.liujiakuo.boss.controller;

import com.liujiakuo.boss.base.http.DataResponse;
import com.liujiakuo.boss.bean.CompanyInfo;
import com.liujiakuo.boss.dao.company.Company;
import com.liujiakuo.boss.dao.company.CompanyService;
import com.liujiakuo.boss.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @RequestMapping("/getByName")
    public DataResponse<List<Company>> getCompanyByName(HttpServletRequest request) {
        DataResponse<List<Company>> response = null;
        String name = request.getParameter("name");
        if (DataUtils.isEmpty(name)) {
            response = new DataResponse<>(302, "参数格式错误");
        } else {
            List<Company> companys = companyService.findCompanyByName(name);
            response = new DataResponse<>(200, "success");
            response.setData(companys);
        }
        return response;
    }

    /**
     * 通过id获取公司
     */
    @RequestMapping("/getCompanyInfo")
    public DataResponse<CompanyInfo> getCompanyInfo(HttpServletRequest request) {
        String cid = request.getParameter("cid");
        if(DataUtils.isEmpty(cid)){
            return new DataResponse(300,"parameter error");
        }
        DataResponse<CompanyInfo> response = new DataResponse<>(200,"success");
        response.setData(companyService.findById(cid));
        return response;
    }
}
