package com.bzdgs.dms.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 *@Description PageList
 * @Author liuqi
 * @param <T>
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageList<T> {

    private long total=0;
    private List<T> rows = new ArrayList<>();
}
