package jp.myapp.servlet.support;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.myapp.servlet.filter.FlashScopeFilter;

import org.springframework.web.servlet.FlashMap;

public class FlashScopeUtils {

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getInputFlashMap(HttpServletRequest request) {
        return (Map<String, Object>) request.getAttribute(FlashScopeFilter.INPUT_FLASH_MAP_ATTRIBUTE);
    }

    public static FlashMap getOutputFlashMap(HttpServletRequest request) {
        return (FlashMap) request.getAttribute(FlashScopeFilter.OUTPUT_FLASH_MAP_ATTRIBUTE);
    }
}
