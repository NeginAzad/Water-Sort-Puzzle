import javafx.scene.paint.Color;

public class ColorArrangment {

    private Color brightSkyBlue = Color.rgb(3, 245, 237);    
    private Color brightLime    = Color.rgb(235, 144, 226);;      
    private Color brightMagenta = Color.rgb(234, 242, 0);;    
    private Color brightCyan    = Color.rgb(240, 33, 33);;    

    private Color[] arr1 = new Color[4];
    private Color[] arr2 = new Color[4];
    private Color[] arr3 = new Color[4];
    private Color[] arr4 = new Color[4];
    private Color[] arr5 = new Color[4]; 
    private Color[] arr6 = new Color[4]; 
    private Color[][] allColors = new Color[6][4];

    public Color[][] type1() {
        arr1 = new Color[]{brightCyan, brightCyan, brightLime, brightLime};
        arr2 = new Color[]{brightMagenta, brightMagenta, brightSkyBlue, brightSkyBlue};
        arr3 = new Color[]{brightCyan, brightLime, brightMagenta, brightSkyBlue};
        arr4 = new Color[]{brightSkyBlue, brightMagenta, brightCyan, brightLime};
        arr5 = new Color[]{null, null, null, null};
        arr6 = new Color[]{null, null, null, null};
        allColors = new Color[][]{arr1, arr2, arr3, arr4, arr5, arr6};
        return allColors;
    }

    public Color[][] type2() {
        arr1 = new Color[]{brightCyan, brightSkyBlue, brightLime, brightMagenta};
        arr2 = new Color[]{brightMagenta, brightCyan, brightSkyBlue, brightLime};
        arr3 = new Color[]{brightLime, brightMagenta, brightCyan, brightSkyBlue};
        arr4 = new Color[]{brightSkyBlue, brightLime, brightMagenta, brightCyan};
        arr5 = new Color[]{null, null, null, null};
        arr6 = new Color[]{null, null, null, null};
        allColors = new Color[][]{arr1, arr2, arr3, arr4, arr5, arr6};
        return allColors;
    }

    public Color[][] type3() {
        arr1 = new Color[]{brightCyan, brightMagenta, brightLime, brightSkyBlue};
        arr2 = new Color[]{brightCyan, brightSkyBlue, brightMagenta, brightLime};
        arr3 = new Color[]{brightSkyBlue, brightLime, brightCyan, brightMagenta};
        arr4 = new Color[]{brightLime, brightCyan, brightSkyBlue, brightMagenta};
        arr5 = new Color[]{null, null, null, null};
        arr6 = new Color[]{null, null, null, null};
        allColors = new Color[][]{arr1, arr2, arr3, arr4, arr5, arr6};
        return allColors;
    }

    public Color[][] type4() {
        arr1 = new Color[]{brightSkyBlue, brightSkyBlue, brightCyan, brightCyan};
        arr2 = new Color[]{brightMagenta, brightMagenta, brightLime, brightLime};
        arr3 = new Color[]{brightLime, brightCyan, brightSkyBlue, brightMagenta};
        arr4 = new Color[]{brightMagenta, brightSkyBlue, brightLime, brightCyan};
        arr5 = new Color[]{null, null, null, null};
        arr6 = new Color[]{null, null, null, null};
        allColors = new Color[][]{arr1, arr2, arr3, arr4, arr5, arr6};
        return allColors;
    }

    public Color[][] type5() {
        arr1 = new Color[]{brightLime, brightSkyBlue, brightMagenta, brightCyan};
        arr2 = new Color[]{brightCyan, brightMagenta, brightSkyBlue, brightLime};
        arr3 = new Color[]{brightMagenta, brightLime, brightCyan, brightSkyBlue};
        arr4 = new Color[]{brightSkyBlue, brightCyan, brightLime, brightMagenta};
        arr5 = new Color[]{null, null, null, null};
        arr6 = new Color[]{null, null, null, null};
        allColors = new Color[][]{arr1, arr2, arr3, arr4, arr5, arr6};
        return allColors;
    }
}