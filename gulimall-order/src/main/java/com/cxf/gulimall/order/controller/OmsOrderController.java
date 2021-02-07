package com.cxf.gulimall.order.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import cn.hutool.core.util.ZipUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.cxf.gulimall.order.entity.ExcelEntity;
import com.cxf.gulimall.order.utils.MultipartFileToFile;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cxf.gulimall.order.entity.OmsOrderEntity;
import com.cxf.gulimall.order.service.OmsOrderService;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.common.utils.R;
import org.springframework.web.multipart.MultipartFile;


/**
 * 订单
 *
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-28 17:52:44
 */
@RestController
@RequestMapping("order/omsorder")
public class OmsOrderController {
    @Autowired
    private OmsOrderService omsOrderService;

    @PostMapping(value = "/zipTest")
    @ResponseBody
    public String zipTest(@RequestParam("uploadFile") MultipartFile uploadFile, @RequestParam("id") Long id) throws IOException {
        File file = MultipartFileToFile.multipartFileToFile(uploadFile);
        //将test.zip解压到e:\\aaa目录下，返回解压到的目录
        File unzip = ZipUtil.unzip(file, Charset.forName("GBK"));
        String name = unzip.getName();
        File[] files = unzip.listFiles();
        //readfile(unzip.getAbsolutePath());
        File file1 = new File(String.valueOf(unzip.getAbsoluteFile()));
        List<String> filelist = new ArrayList<String>();
        List<String> list = getAllFiles(file1, filelist);
        for (String fileName : list) {
            if (fileName.endsWith("xls")) {
                File readfile = new File(fileName);
                //解析xls
                //解析请单
                ExcelReader reader = ExcelUtil.getReader(readfile.getPath());
                List<ExcelEntity> list1 = reader.readAll(ExcelEntity.class);
                Stream<ExcelEntity> excelEntityStream =
                        list1.stream();
                List<ExcelEntity> collect = excelEntityStream.collect(Collectors.toList());
                for (ExcelEntity excel : collect) {
                    if (excel.getDescription().isEmpty()) {
                        return excel.getLibRef() + "为空！";
                    }
                    if (excel.getDesignator().isEmpty()) {
                        return excel.getLibRef() + "为空！";
                    }
                }
                System.out.println("xls的数据为：" + collect);
                reader.close();
            }
            if (fileName.endsWith("PcbDoc")) {
                File readfile = new File(fileName);
                String filetrueName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                String name1 = filetrueName.substring(0, filetrueName.lastIndexOf("."));
                String[] split = name1.split("_");
                System.out.println("name1为：" + name1);
                System.out.println("spilt[0]为：" + split[0]);
                System.out.println("spilt[1]为" + split[1]);


            }
        }
        System.out.println(list);
        MultipartFileToFile.deleteFolder(file1);
        MultipartFileToFile.deleteFile(file);

        return name + id;
    }

    /**
     * 获取多级文件中的多个文件
     *
     * @param dir
     * @param filelist
     * @return
     */
    public static List<String> getAllFiles(File dir, List<String> filelist) {
        File[] fs = dir.listFiles();
        for (File f : fs) {
            if (f.isDirectory()) {
                getAllFiles(f, filelist);
            }
            if (f.getName().contains("._") || f.getName().startsWith(".")) {
                continue;
            }
            //否则就是文件
            if (f.getName().endsWith("PcbDoc") || f.getName().endsWith("pdf")) {
                filelist.add(f.getAbsolutePath());
            }
        }
        return filelist;
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:omsorder:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = omsOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:omsorder:info")
    public R info(@PathVariable("id") Long id) {
        OmsOrderEntity omsOrder = omsOrderService.getById(id);

        return R.ok().put("omsOrder", omsOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:omsorder:save")
    public R save(@RequestBody OmsOrderEntity omsOrder) {
        omsOrderService.save(omsOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:omsorder:update")
    public R update(@RequestBody OmsOrderEntity omsOrder) {
        omsOrderService.updateById(omsOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:omsorder:delete")
    public R delete(@RequestBody Long[] ids) {
        omsOrderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
