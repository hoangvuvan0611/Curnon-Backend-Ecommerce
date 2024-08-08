package org.vvh.curnonbackendecommerce.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseDataList<T>{
    private final int total;
    private final List<T> dataList;

    public ResponseDataList(List<T> dataList) {
        this.dataList = dataList;
        this.total = dataList.size();
    }
}
