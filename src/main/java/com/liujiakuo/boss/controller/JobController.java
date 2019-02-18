package com.liujiakuo.boss.controller;

import com.liujiakuo.boss.base.http.DataResponse;
import com.liujiakuo.boss.base.http.PageDataResponse;
import com.liujiakuo.boss.bean.PositionBean;
import com.liujiakuo.boss.dao.job.Job;
import com.liujiakuo.boss.dao.job.JobServiceImp;
import com.liujiakuo.boss.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobServiceImp jobServiceImp;

    @RequestMapping("/findJob")
    public DataResponse<List<PositionBean>> findJobByName(HttpServletRequest request) {
        DataResponse<List<PositionBean>> response = null;
        String name = request.getParameter("name");
        if (DataUtils.isEmpty(name)) {
            response = new DataResponse<>(300, "参数错误");
        } else {
            List<PositionBean> jobs = jobServiceImp.findByName(name);
            if (DataUtils.isEmpty(jobs)) {
                response = new DataResponse<>(300, "not found");
            } else {
                response = new DataResponse<>(200, "success");
                response.setData(jobs);
            }
        }
        return response;
    }

    @RequestMapping("/getJobList")
    public PageDataResponse<List<PositionBean>> getJobList(HttpServletRequest request) {
        int page = 0;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        page = page < 0 ? 0 : page;
        List<PositionBean> jobList = jobServiceImp.getJobList(page);
        if (DataUtils.isEmpty(jobList)) {
            //没有更多的数据
            PageDataResponse<List<PositionBean>> response = new PageDataResponse<>(200, "已无更多数据");
            response.setPage(page);
            return response;
        }
        PageDataResponse<List<PositionBean>> response = new PageDataResponse<>(200, "success");
        response.setData(jobList);
        response.setPage(++page);//增加当前页
        return response;
    }
}
