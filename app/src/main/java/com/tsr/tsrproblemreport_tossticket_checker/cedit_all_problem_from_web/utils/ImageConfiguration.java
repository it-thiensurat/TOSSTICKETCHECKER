package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.graphics.BitmapCompat;
import android.util.Log;

import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by teerayut.k on 11/13/2017.
 */

public class ImageConfiguration {

    private static Context context;
    private String dirName;
    private String path;

    public ImageConfiguration(Context context,String P) {
        this.context = context;
        this.path=P;
    }

    public File createImageFile(String dirName) {
        File image = null;
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            File storageDir = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + dirName + "/");
            }
            image = File.createTempFile(
                    imageFileName,
                    ".jpg",
                    storageDir
            );
        } catch (IOException ex) {

        }
        return image;
    }

    public File createImage(String dirName, String imgName) {
        File image = null;
        try {
            //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + dirName + "_" + imgName;
            File storageDir = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + dirName + "/");
            }
            image = File.createTempFile(
                    imageFileName,
                    ".jpg",
                    storageDir
            );
        } catch (IOException ex) {

        }
        return image;
    }
    String VersionOS="";
    public File createImageByType_error(String imgdir,String type,String ID) {
        File image = null;
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String imageName = "image_error"+"_"+df.format(now);
        MyApplication.getInstance().getPrefManager().setPreferrence("imageName", imageName);
        File storageDir = null;

        try {
            VersionOS = android.os.Build.VERSION.RELEASE;

            if((VersionOS.equals("6.0"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.0.1"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){







                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");
                MyApplication.getInstance().getPrefManager().setPreferrence("part_image", "/sdcard/Android/data/"+context.getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");



            }

            else {
      /*          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {

                    //storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");

                    storageDir = context.getExternalFilesDir(path + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");


                }*/


                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");
                MyApplication.getInstance().getPrefManager().setPreferrence("part_image", "/sdcard/Android/data/"+context.getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");

           //     String DD= String.valueOf(storageDir);
            //    MyApplication.getInstance().getPrefManager().setPreferrence("part_image", DD);
            }
        }
        catch (Exception C){
   /*         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");

            }*/
        /*    String DD= String.valueOf(storageDir);
            MyApplication.getInstance().getPrefManager().setPreferrence("part_image", DD);

*/


            storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");
            MyApplication.getInstance().getPrefManager().setPreferrence("part_image", "/sdcard/Android/data/"+context.getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");


        }
      //  Environment.getExternalStorageDirectory();

            /*
            image = File.createTempFile(
                    imageName,
                    ".jpg",
                    storageDir
            );*/


        image = new File(storageDir, imageName+".jpg");
        return image;
    }






    public File createImageByType_error_checker(String imgdir,String type,String ID) {
        File image = null;
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String imageName = "image_error"+"_"+df.format(now);
        MyApplication.getInstance().getPrefManager().setPreferrence("imageName", imageName);
        File storageDir = null;

        try {
            VersionOS = android.os.Build.VERSION.RELEASE;

            if((VersionOS.equals("6.0"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.0.1"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){







                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");
                MyApplication.getInstance().getPrefManager().setPreferrence("part_image", "/sdcard/Android/data/"+context.getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");



            }

            else {



/*                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {

                    //storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");

                    storageDir = context.getExternalFilesDir(path + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");


                }
                String DD= String.valueOf(storageDir);
                MyApplication.getInstance().getPrefManager().setPreferrence("part_image", DD);*/



                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");
                MyApplication.getInstance().getPrefManager().setPreferrence("part_image", "/sdcard/Android/data/"+context.getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");





            }
        }
        catch (Exception C){
/*            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");

            }
            String DD= String.valueOf(storageDir);
            MyApplication.getInstance().getPrefManager().setPreferrence("part_image", DD);*/

            storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");
            MyApplication.getInstance().getPrefManager().setPreferrence("part_image", "/sdcard/Android/data/"+context.getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");



        }
        //  Environment.getExternalStorageDirectory();

            /*
            image = File.createTempFile(
                    imageName,
                    ".jpg",
                    storageDir
            );*/
        image = new File(storageDir, imageName+".jpg");
        return image;
    }

    public File createImageByType_map(String imgdir,String type,String ID) {
        File image = null;
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String imageName = "image_map"+"_"+df.format(now);
        MyApplication.getInstance().getPrefManager().setPreferrence("imageName", imageName);
        File storageDir = null;

        try {
            VersionOS = android.os.Build.VERSION.RELEASE;

            if((VersionOS.equals("6.0"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.0.1"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_map" + "/");
                MyApplication.getInstance().getPrefManager().setPreferrence("part_image", "/sdcard/Android/data/"+context.getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_map" + "/");

            }

            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {

                    //storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");

                    storageDir = context.getExternalFilesDir(path + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_map" + "/");


                }
                String DD= String.valueOf(storageDir);
                MyApplication.getInstance().getPrefManager().setPreferrence("part_image", DD);
            }
        }
        catch (Exception C){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_map" + "/");

            }
            String DD= String.valueOf(storageDir);
            MyApplication.getInstance().getPrefManager().setPreferrence("part_image", DD);


        }
        //  Environment.getExternalStorageDirectory();

            /*
            image = File.createTempFile(
                    imageName,
                    ".jpg",
                    storageDir
            );*/


        image = new File(storageDir, imageName+".jpg");

        return image;
    }
    public File createImageByType_pen_sing(String imgdir,String type,String ID) {
        File image = null;
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String imageName = "image_pen_sing"+"_"+df.format(now);
        MyApplication.getInstance().getPrefManager().setPreferrence("imageName", imageName);
        File storageDir = null;

        try {
            VersionOS = android.os.Build.VERSION.RELEASE;

            if((VersionOS.equals("6.0"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.0.1"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_pen_sing" + "/");
                MyApplication.getInstance().getPrefManager().setPreferrence("part_image", "/sdcard/Android/data/"+context.getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_pen_sing" + "/");

            }

            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {

                    //storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");

                    storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + "image_pen_sing"+ "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_pen_sing" + "/");


                }
                String DD= String.valueOf(storageDir);
                MyApplication.getInstance().getPrefManager().setPreferrence("part_image", DD);
            }
        }
        catch (Exception C){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_pen_sing" + "/");

            }
            String DD= String.valueOf(storageDir);
            MyApplication.getInstance().getPrefManager().setPreferrence("part_image", DD);


        }
        //  Environment.getExternalStorageDirectory();

            /*
            image = File.createTempFile(
                    imageName,
                    ".jpg",
                    storageDir
            );*/
        image = new File(storageDir, imageName+".jpg");
        return image;
    }
    public File createImageByType_edit(String imgdir,String type,String ID) {
        File image = null;
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String imageName = "image_edit"+"_"+df.format(now);
        MyApplication.getInstance().getPrefManager().setPreferrence("imageName", imageName);
        File storageDir = null;

        try {
            VersionOS = android.os.Build.VERSION.RELEASE;



            if((VersionOS.equals("6.0"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.0.1"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_edit" + "/");
                MyApplication.getInstance().getPrefManager().setPreferrence("part_image", "/sdcard/Android/data/"+context.getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_edit" + "/");

            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                    //storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/"+type+ "/"+"ID"+ID+ "/"+"image_edit"+"/");
                    storageDir = context.getExternalFilesDir(path + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_error" + "/");
                }
                String DD= String.valueOf(storageDir);
                MyApplication.getInstance().getPrefManager().setPreferrence("part_image", DD);
            }
        }

        catch (Exception C){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/"+type+ "/"+"ID"+ID+ "/"+"image_edit"+"/");
            }
            String DD= String.valueOf(storageDir);
            MyApplication.getInstance().getPrefManager().setPreferrence("part_image", DD);


        }


            /*
            image = File.createTempFile(
                    imageName,
                    ".jpg",
                    storageDir
            );*/
        image = new File(storageDir, imageName+".jpg");
        return image;
    }

    public File createImageByType_sucess(String imgdir,String type,String ID) {
        File image = null;
        try {
            Date now = new Date();
            DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
            String imageName = "image_success"+"_"+df.format(now);

            File storageDir = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + imgdir + "/"+type+ "/"+"ID"+ID+ "/"+"image_success"+"/");
            }
            image = File.createTempFile(
                    imageName,
                    ".jpg",
                    storageDir
            );
        } catch (IOException e) {

        }
        return image;
    }

    public File createImagePNG(String dirName, String imgName) {
        File image = null;
        try {
            //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            //String imageFileName = dirName + "_" + imgName;
            File storageDir = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + dirName + "/");
            }
            image = File.createTempFile(
                    imgName,
                    ".png",
                    storageDir
            );
        } catch (IOException ex) {

        }
        return image;
    }

    public void removeImage(String url) {
        File fileimage = null;
        fileimage = new File(url);
        if (fileimage.exists()) {
            if (fileimage.delete()) {

            }
        }
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    public File getAlbumStorageDir(String albumName) {
        File file = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), albumName);
        }
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

  /*  public Bitmap getResizedBiBitmaptmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        bm.recycle();

        Log.e("resizedBitmap", String.valueOf(resizedBitmap));


        return resizedBitmap;
    }*/

    public static Bitmap resizeBitmap(Bitmap source, int maxLength) {
        try {
            if (source.getHeight() >= source.getWidth()) {
                int targetHeight = maxLength;
                if (source.getHeight() <= targetHeight) { // if image already smaller than the required height
                    return source;
                }

                double aspectRatio = (double) source.getWidth() / (double) source.getHeight();
                int targetWidth = (int) (targetHeight * aspectRatio);

                Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
                return result;
            } else {
                int targetWidth = maxLength;

                if (source.getWidth() <= targetWidth) { // if image already smaller than the required height
                    return source;
                }

                double aspectRatio = ((double) source.getHeight()) / ((double) source.getWidth());
                int targetHeight = (int) (targetWidth * aspectRatio);

                Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
                return result;

            }
        } catch (Exception e) {
            return source;
        }
    }

    /**
     *
     * Created by Teerayut Klinsanga
     * Date 17/05/2021 11:30
     *
     */
    public Bitmap NewresizeBitmap(Bitmap bmp) {
        int maxImageSize = 300 * 1024;
//        int width = bmp.getWidth();
//        int height = bmp.getHeight();
        int bounding = dpToPx(480);

        float ratio = Math.min((float) maxImageSize / bmp.getWidth(), (float) maxImageSize / bmp.getHeight());
        int width = Math.round((float) ratio * bmp.getWidth());
        int height = Math.round((float) ratio * bmp.getHeight());

        float xScale = ((float) bounding) / width;
        float yScale = ((float) bounding) / height;
        float scale = (xScale <= yScale) ? xScale : yScale;

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        Bitmap b2 = Bitmap.createBitmap(bmp, 0, 0, width, height, matrix, true);

//        Bitmap b2 = Bitmap.createScaledBitmap(bmp, Integer.parseInt(String.valueOf(xScale)), Integer.parseInt(String.valueOf(yScale)), true);
        File storageDir = context.getExternalFilesDir(
                Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/" + "report_problem" + "/" + "ID" + "ALL" + "/" + "image_error" + "/");

        File imageFile = null;
        FileOutputStream fileoutStream = null;
        try {
            imageFile = new File(storageDir, MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new"+".png");
            fileoutStream = new FileOutputStream(imageFile);
            b2.compress(Bitmap.CompressFormat.JPEG, 80, fileoutStream);
            fileoutStream.flush();
            fileoutStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BitmapFactory.decodeFile(imageFile.getAbsolutePath());
    }

    private int dpToPx(int dp) {
        float density = this.context.getResources().getDisplayMetrics().density;
        return Math.round((float)dp * density);
    }

    /**
     * End
     */



/*
    public Bitmap getResizedBiBitmaptmap(Bitmap bm, String IN_SELECT) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        int bitmapByteCount= BitmapCompat.getAllocationByteCount(bm);
        bitmapByteCount=(bitmapByteCount/10000)/10;
        Log.e("resizedBitmap1", String.valueOf(bitmapByteCount));
        float scaleWidth = 0,scaleHeight=0;
        float x=bitmapByteCount/100;
        //float x2=bitmapByteCount/10;
        if(IN_SELECT.equals("camera")){
            //int x=0;
            //x=bitmapByteCount/400;
            scaleWidth = ((float) width/x) / width;
            scaleHeight = ((float) height/x) / height;
         //   tt=scaleWidth/500;
          //  tt2=scaleHeight/500;
            Log.e("scaleWidth_x", String.valueOf(scaleWidth));
            Log.e("scaleWidth_y", String.valueOf(scaleHeight));
            scaleWidth=scaleWidth/2;
            scaleHeight=scaleHeight/2;

        } else {
            scaleWidth = ((float) width/x) / width;
            scaleHeight = ((float) height/x) / height;
            scaleWidth=scaleWidth/2;
            scaleHeight=scaleHeight/2;
        }

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        Log.e("resizedBitmap2", String.valueOf(resizedBitmap));
        convertToPNG(resizedBitmap);
        return resizedBitmap;
    }
    */




    public static Bitmap convertToPNG(Bitmap image) {

        File storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/" + "report_problem" + "/" + "ID" + "ALL" + "/" + "image_error" + "/");
        // MyApplication.getInstance().getPrefManager().setPreferrence("part_image", "/sdcard/Android/data/"+context.getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_edit" + "/");
        File imageFile = null;
     /*   File imageFile = null;
        try {
            imageFile = File.createTempFile(
                    "ssss",  *//* prefix *//*
                    ".png",         *//* suffix *//*
                    storageDir      *//* directory *//*
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        */




        FileOutputStream outStream = null;
        try {

            imageFile = new File(storageDir, MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new"+".png");

            outStream = new FileOutputStream(imageFile);
            image.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.flush();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BitmapFactory.decodeFile(imageFile.getAbsolutePath());
    }




    public void createSingleImageFromMultipleImages(Bitmap firstImage, Bitmap secondImage, File path) throws IOException {
        Bitmap result = Bitmap.createBitmap((firstImage.getWidth() + secondImage.getWidth()), firstImage.getHeight(), Bitmap.Config.RGB_565 );
        Canvas canvas = new Canvas(result);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(firstImage, 0, 0, null);
        canvas.drawBitmap(secondImage, firstImage.getWidth(), 0, null);
        OutputStream stream = new FileOutputStream(path);
        result.compress(Bitmap.CompressFormat.JPEG, 90, stream);
        stream.close();
    }














    public static String resizeAndCompressImageBeforeSend(Context context,String filePath,String fileName){
        final int MAX_IMAGE_SIZE = 700 * 1024; // max final file size in kilobytes

        // First decode with inJustDecodeBounds=true to check dimensions of image
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath,options);

        // Calculate inSampleSize(First we are going to resize the image to 800x800 image, in order to not have a big but very low quality image.
        //resizing the image will already reduce the file size, but after resizing we will check the file size and start to compress image
        options.inSampleSize = calculateInSampleSize(options, 800, 800);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        options.inPreferredConfig= Bitmap.Config.ARGB_8888;

        Bitmap bmpPic = BitmapFactory.decodeFile(filePath,options);


        int compressQuality = 100; // quality decreasing by 5 every loop.
        int streamLength;
        do{
            ByteArrayOutputStream bmpStream = new ByteArrayOutputStream();
            Log.e("compressBitmap", "Quality: " + compressQuality);
            bmpPic.compress(Bitmap.CompressFormat.JPEG, compressQuality, bmpStream);
            byte[] bmpPicByteArray = bmpStream.toByteArray();
            streamLength = bmpPicByteArray.length;
            compressQuality -= 5;
            Log.e("compressBitmap", "Size: " + streamLength/1024+" kb");
        }while (streamLength >= MAX_IMAGE_SIZE);

        try {
            //save the resized and compressed file to disk cache
            Log.d("compressBitmap","cacheDir: "+context.getCacheDir());
            FileOutputStream bmpFile = new FileOutputStream(context.getCacheDir()+fileName);
            bmpPic.compress(Bitmap.CompressFormat.JPEG, compressQuality, bmpFile);
            bmpFile.flush();
            bmpFile.close();
        } catch (Exception e) {
            Log.e("compressBitmap", "Error on saving file");
        }
        //return the path of resized and compressed file
        return  context.getCacheDir()+fileName;
    }



    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        String debugTag = "MemoryInformation";
        // Image nin islenmeden onceki genislik ve yuksekligi
        final int height = options.outHeight;
        final int width = options.outWidth;
        Log.e(debugTag,"image height: "+height+ "---image width: "+ width);
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        Log.e(debugTag,"inSampleSize: "+inSampleSize);
        return inSampleSize;
    }
















    public Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565 ); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.RGB_565 );
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}
