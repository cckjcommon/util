package com.chengchengtech.util.verify;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.*;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Author: Tao.Wang
 * Date: 2018/5/19
 * Time: 下午9:44
 * Org : 思笛恩
 * To change this template use File | Settings | File Templates.
 * Description:
 *
 * @author: Tao.Wang
 */
public class CodePic {


    public static VerifyCodePicResult gerateVerifyCodePic() throws IOException {
        int codeCount = 4;
        //图片的宽和高
        int imgWidth = codeCount * 20;
        int imgHeight = 30;

        BufferedImage buffImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_BGR);
        String chapter = drawImg(buffImg, codeCount, imgWidth, imgHeight);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(buffImg, "png", bos);
        VerifyCodePicResult verifyCodePicResult = new VerifyCodePicResult(bos.toByteArray(), chapter);
        return verifyCodePicResult;
    }

    /**
     * 生成验证码图片，并返回验证码的值
     *
     * @param codeCount 验证码个数
     * @param picName   图片文件名
     * @param suffix    图片文件格式(png/jpeg)
     * @return 验证码的值
     */
    public static String generateImg(int codeCount, String picName, String suffix) {
        //图片的宽和高
        int imgWidth = codeCount * 20;
        int imgHeight = 30;

        BufferedImage buffImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_BGR);
        String chapter = drawImg(buffImg, codeCount, imgWidth, imgHeight);
        //如果图片文件名为空，那么使用验证码的值作为图片文件名
        picName = picName == null ? chapter : picName;
        outputPic(buffImg, picName, suffix);
        return chapter;
    }

    /**
     * 根据宽度、高度、和验证码的个数绘制验证码图片，并返回验证码的值
     *
     * @param buffImg   BufferedImage对象
     * @param codeCount 验证码个数
     * @param imgWidth  图片宽度
     * @param imgHeight 图片高度
     * @return 验证码的值
     */
    private static String drawImg(BufferedImage buffImg, int codeCount, int imgWidth, int imgHeight) {
        Random rand = new Random();
        Graphics2D gd = buffImg.createGraphics();

        //填充矩形
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, imgWidth, imgHeight);

        //设置字体
        Font font = new Font("微软雅黑", Font.PLAIN, imgHeight - 5);
        gd.setFont(font);

        //绘制边框
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, imgWidth - 1, imgHeight - 1);

        //绘制灰色干扰线
        gd.setColor(Color.GRAY);
        for (int i = 0, x, y, x1, y1; i < 30; i++) {
            x = rand.nextInt(imgWidth);
            y = rand.nextInt(imgHeight);
            x1 = rand.nextInt(12);
            y1 = rand.nextInt(12);
            gd.drawLine(x, y, x + x1, y + y1);
        }

        //int codeCount = 4,
        int codeX = 15, codeY = 25;

        //记录验证码
        StringBuffer chapter = new StringBuffer();

        //临时变量
        String strRand;
        char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0, red, green, blue; i < codeCount; i++) {
            //随机获取字符
            strRand = String.valueOf(codeSequence[rand.nextInt(codeSequence.length)]);

            //随机选择字符颜色
            red = rand.nextInt(255);
            green = rand.nextInt(255);
            blue = rand.nextInt(255);
            gd.setColor(new Color(red, green, blue));

            //绘制字符
            gd.drawString(strRand, (i + 1) * codeX, codeY);

            //记录字符
            chapter.append(strRand);
        }

        return chapter.toString();
    }

    /**
     * 将绘制完毕的图片输出成文件
     *
     * @param buffImg  绘制完毕的验证码图片
     * @param fileName 文件名
     * @param suffix   后缀(png/jpeg)
     * @return 文件绝对路径
     */
    public static String outputPic(BufferedImage buffImg, String fileName, String suffix) {
        try {
            int index = 1;
            File file = new File(fileName + "." + suffix);
            while (file.exists()) {
                file = new File(fileName + "(" + (index++) + ")." + suffix);
            }
            FileOutputStream fos = new FileOutputStream(file);
            ImageIO.write(buffImg, suffix, fos);
            fos.close();
            return file.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 显示字体列表
     */
    public static void showFontList() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        for (String font : fonts) {
            System.out.println(font);
        }
    }

    //试图扭曲图片，失败了
    /*
    public static void getImgArr(BufferedImage buffImg) {
        int offX = 20;
        int offY = 20;
        int height = buffImg.getHeight();
        int width = buffImg.getWidth();
        System.out.println("width:" + width + " height:" + height);
        int[][] rgbs = new int[width][height];
        for (int i = buffImg.getMinY(); i < width; i++) {
            for (int j = buffImg.getMinX(); j < height; j++) {
                if (i - offX  < width && i - offX >= 0) {
                    buffImg.setRGB(i - offX, j, buffImg.getRGB(i, j));
                }


                //if (j - offY  < height && j - offY >= 0) {
                    //buffImg.setRGB(i, j - offY, buffImg.getRGB(i, j));
                //}

            }
            //offY -= 2;
            offX--;
        }
    }
*/
}
