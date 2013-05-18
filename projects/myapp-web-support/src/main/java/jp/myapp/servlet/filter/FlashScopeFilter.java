package jp.myapp.servlet.filter;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.myapp.servlet.support.FlashScopeUtils;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.SessionFlashMapManager;

public class FlashScopeFilter extends OncePerRequestFilter {

    private static final String ATTRIBUTE_KEY_PREFIX = FlashScopeFilter.class.getName();
    public static final String INPUT_FLASH_MAP_ATTRIBUTE = ATTRIBUTE_KEY_PREFIX + ".INPUT_FLASH_MAP";
    public static final String OUTPUT_FLASH_MAP_ATTRIBUTE = ATTRIBUTE_KEY_PREFIX + ".OUTPUT_FLASH_MAP";
    public static final String FLASH_MAP_MANAGER_ATTRIBUTE = ATTRIBUTE_KEY_PREFIX + ".FLASH_MAP_MANAGER";
    private FlashMapManager flashMapManager;

    public void setFlashMapManager(FlashMapManager flashMapManager) {
        this.flashMapManager = flashMapManager;
    }

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        if (this.flashMapManager == null) {
            this.flashMapManager = new SessionFlashMapManager();
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        FlashMap inputFlashMap = this.flashMapManager.retrieveAndUpdate(request, response);
        if (inputFlashMap != null) {
            request.setAttribute(INPUT_FLASH_MAP_ATTRIBUTE, Collections.unmodifiableMap(inputFlashMap));
        }
        request.setAttribute(OUTPUT_FLASH_MAP_ATTRIBUTE, new FlashMap());
        request.setAttribute(FLASH_MAP_MANAGER_ATTRIBUTE, this.flashMapManager);

        try {
            filterChain.doFilter(request, response);

        } finally {
            FlashMap outputFlashMap = FlashScopeUtils.getOutputFlashMap(request);
            this.flashMapManager.saveOutputFlashMap(outputFlashMap, request, response);
        }
    }
}
