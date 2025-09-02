package org.github.bm.system;

import lombok.*;

/**
 * Time 2025-09-02 16:01
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@Setter
@ToString
public class Test {
    public static void main(String[] args) {
        Boolean readAll =null;
        System.out.println("Boolean.FALSE.equals(readAll) = " + Boolean.FALSE.equals(readAll));
        System.out.println("Boolean.FALSE.equals(false) = " + Boolean.FALSE.equals(false));
        System.out.println("Boolean.FALSE.equals(true) = " + Boolean.FALSE.equals(true));
        if (Boolean.FALSE.equals(readAll)) {

        }
    }
}
