package com.cxf.gulimall.order.entity;

import lombok.Data;
import org.omg.PortableServer.ServantLocator;

import java.io.Serializable;

/**
 * @author xfchai
 * @ClassName ExcelEntity.java
 * @Description TODO
 * @createTime 2021/02/03 14:15:00
 */
@Data
public class ExcelEntity implements Serializable {
    private String Comment;
    private String Description;
    private String Designator;
    private String Footprint;
    private String LibRef;
    private String Quantity;
}
