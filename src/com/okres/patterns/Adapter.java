package com.okres.patterns;

public class Adapter {
    public static void main(String[] args) {
        VectorGraphicsInterface v1 = new VectorAdapterFromRaster();
        v1.drawLine();
        v1.drawSquare();

        VectorGraphicsInterface v2 = new VectorAdapterFromRaster2();
        v2.drawLine();
        v2.drawSquare();
    }
}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Draw line");
    }

    void drawRasterSquare() {
        System.out.println("Draw square");
    }
}

//Version №1 - implementation throw inheritance
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
    @Override
    public void drawLine() {
        drawRasterLine();
    }
    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

//Version №2 - implementation throw composition
class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
    RasterGraphics rasterGraphics = new RasterGraphics();
    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}