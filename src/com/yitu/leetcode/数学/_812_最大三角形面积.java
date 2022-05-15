package com.yitu.leetcode.数学;

/**
 * https://leetcode.cn/problems/largest-triangle-area/
 */
public class _812_最大三角形面积 {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ret = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    ret = Math.max(ret, triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return ret;
    }

    /**
     * 海伦公式
     * 通过已知三角形三边之长求得三角形面积的公式
     */
    public double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        // 求两点之间的距离 使用勾股定理
        double a = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double b = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double c = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        // 得到三条边的长度使用海伦公式计算其面积
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return Double.isNaN(s) || Double.isInfinite(s) ? Double.MIN_VALUE : s;
    }

    public static void main(String[] args) {
        int[][] points = {{-35, 19}, {40, 19}, {27, -20}, {35, -3}, {44, 20}, {22, -21}, {35, 33}, {-19, 42}, {11, 47}, {11, 37}};
        double s = new _812_最大三角形面积().largestTriangleArea(points);
        System.out.println(s);

    }
}
