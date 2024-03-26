package com.jyx.netty.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName: DistributeControl
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-25 10:23
 **/
@Data
@Builder
@ToString
public class DistributeControl implements Serializable {

    private String serverId;

    private String commandCode;

}
