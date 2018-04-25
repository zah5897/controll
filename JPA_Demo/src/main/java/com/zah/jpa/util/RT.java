package com.zah.jpa.util;

import com.zah.jpa.exception.Err;
import org.springframework.ui.ModelMap;


public class RT {
    public static ModelMap getResultMap(Err error, String msg) {
        ModelMap result = new ModelMap();
        result.addAttribute("code", error.getValue());
        result.addAttribute("msg", msg);
        return result;
    }

    public static ModelMap getResultMap(Err error) {
        ModelMap result = new ModelMap();
        result.addAttribute("code", error.getValue());
        result.addAttribute("msg", error.getErrorMsg());
        return result;
    }

    public static ModelMap getResultOKMap(String msg) {
        ModelMap result = new ModelMap();
        result.addAttribute("code", Err.ERR_SUCCESS.getValue());
        result.addAttribute("msg", msg);
        return result;
    }

    public static ModelMap getResultOKMap() {
        ModelMap result = new ModelMap();
        result.addAttribute("code", Err.ERR_SUCCESS.getValue());
        result.addAttribute("msg", Err.ERR_SUCCESS.getErrorMsg());
        return result;
    }

    public static ModelMap getFailed() {
        ModelMap result = new ModelMap();
        result.addAttribute("code", Err.ERR_FAILED.getValue());
        result.addAttribute("msg", Err.ERR_FAILED.getErrorMsg());
        return result;
    }
}
