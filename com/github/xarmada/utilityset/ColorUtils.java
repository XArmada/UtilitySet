package com.github.xarmada.utilityset;

import java.awt.Color;

public class ColorUtils {
    public static int getRainbow() {
        final float hue = System.currentTimeMillis() % 4000L / 4000.0f;
        final int color = Color.HSBtoRGB(hue, 1.0f, 1.0f);
        return color;
    }
    
    
    public static int toRGBA(final int r, final int g, final int b, final int a) {
        return (r << 16) + (g << 8) + (b << 0) + (a << 24);
    }
    
    public static int toRGBA(final float r, final float g, final float b, final float a) {
        return toRGBA((int)(r * 255.0f), (int)(g * 255.0f), (int)(b * 255.0f), (int)(a * 255.0f));
    }
    
    
}
