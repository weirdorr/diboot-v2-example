package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.KeyValue;
import com.diboot.core.vo.Pagination;
import com.diboot.core.vo.Status;
import com.example.entity.Department;
import com.example.service.DepartmentService;
import com.example.vo.DepartmentVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Department相关Controller示例
 * @author Mazc
 * @version v2.0
 * @date 2019/1/19
 */
@RestController
@RequestMapping("/department")
public class DepartmentController extends BaseCrudMappingRestController<Department, DepartmentVO> {
    private final static Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    /***
     * 查询ViewObject的分页数据 (此为非继承的自定义使用案例，更简化的调用父类案例请参考UserController)
     * <p>
     * url参数示例: /list?pageSize=20&pageIndex=1&orderBy=id&code=TST
     * </p>
     * @return
     * @throws Exception
     */
    @GetMapping("/voList")
    public JsonResult getVOList(Department department, Pagination pagination, HttpServletRequest request) throws Exception{
        // 将Entity
        QueryWrapper<Department> queryWrapper = super.buildQueryWrapper(department, request);
        // 查询当前页的Entity主表数据
        List entityList = getService().getEntityList(queryWrapper, pagination);
        // 自动转换VO中注解绑定的关联
        List<DepartmentVO> voList = super.convertToVoAndBindRelations(entityList, DepartmentVO.class);
        // 返回结果
        return new JsonResult(Status.OK, voList).bindPagination(pagination);
    }

    /***
     * 查询ViewObject全部数据 (此为非继承的自定义使用案例，更简化的调用父类案例请参考UserController)
     * <p>
     * url参数示例: /listAll?orderBy=id&code=TST
     * </p>
     * @return
     * @throws Exception
     */
    @GetMapping("/listAll")
    public JsonResult getAllVOList(Department department, HttpServletRequest request) throws Exception{
        QueryWrapper<Department> queryWrapper = super.buildQueryWrapper(department, request);
        // 查询当前页的Entity主表数据
        List entityList = getService().getEntityList(queryWrapper);
        // 自动转换VO中注解绑定的关联
        List<DepartmentVO> voList = super.convertToVoAndBindRelations(entityList, DepartmentVO.class);
        // 返回结果
        return new JsonResult(Status.OK, voList);
    }

    /**
     * ID-Name的映射键值对，用于前端Select控件筛选等
     * @param request
     * @return
     */
    @GetMapping("/kv")
    public JsonResult getKVPairList(HttpServletRequest request){
        Wrapper wrapper = new QueryWrapper<Department>().lambda()
            .select(Department::getName, Department::getId, Department::getCreateTime);
        List<KeyValue> list = departmentService.getKeyValueList(wrapper);
        return new JsonResult(list);
    }

}
