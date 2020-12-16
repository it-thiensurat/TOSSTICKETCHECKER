package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.check_for_credit;

import android.app.Dialog;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tsr.tsrproblemreport_tossticket_checker.R;

/**
 * Created by Parsania Hardik on 23/04/2016.
 */
public class SlidingImage_Adapter extends PagerAdapter {


    private String[] urls;
    private LayoutInflater inflater;
    private Context context;




    public static  int i=0;
    public static  int j=0;
    public static  int k=0;

    public static  int x=0;
    public static  int y=0;
    public static  int z=0;


    public SlidingImage_Adapter(Context context, String[] urls) {
        this.context = context;
        this.urls = urls;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return urls.length;
    }





    String[] sampleTitles = {"PRODUCT", "ID CARD", "MAP", "ADDRESS", "PAYMENT CARD", "MAP PAYMENT"};

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);

        TextView labelTextView = (TextView) imageLayout.findViewById(R.id.labelTextView);


        Glide.with(context)
                .load(urls[position])
                .placeholder(context.getResources().getDrawable(R.drawable.no_image))
                .into(imageView);

        labelTextView.setText(sampleTitles[position]);


        imageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                if(position == 0){




                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);

                    final ImageView image_full=(ImageView)dialog.findViewById(R.id.image_remove);

                    try {
                        Glide.with(context).load(urls[position])

                                .placeholder(context.getResources().getDrawable(R.drawable.no_image))

                                .into(image_map);




                    }
                    catch (Exception e) {

                    }



                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            i=i+90;
                            image_map.setRotation((float) i);

                        }
                    });




                    image_full.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {







                        final Dialog dialog = new Dialog(context);
                            dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog.setContentView(R.layout.custom_dialog_image_cedit_full);

                            int width = ViewGroup.LayoutParams.MATCH_PARENT;
                            int height = ViewGroup.LayoutParams.MATCH_PARENT;
                            dialog.getWindow().setLayout(width, height);
                            dialog.getWindow().setWindowAnimations(R.style.FullScreenDialogStyle);

                            dialog.setCancelable(true);
                            final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                            final ImageView image_remove=(ImageView)dialog.findViewById(R.id.image_remove);
                            final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);

                            rotage2.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    k=k+90;
                                    image_map.setRotation((float) k);

                                }
                            });
                            image_remove.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            try {
                                Glide.with(context).load(urls[position])

                                        .placeholder(context.getResources().getDrawable(R.drawable.no_image))

                                        .into(image_map);




                            }
                            catch (Exception e) {

                            }



                            dialog.show();
                        }
                    });




                    dialog.show();






                }   else if(position == 1){


                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                    final ImageView image_full=(ImageView)dialog.findViewById(R.id.image_remove);
                    try {
                        Glide.with(context).load(urls[position])

                                .placeholder(context.getResources().getDrawable(R.drawable.no_image))
                                .into(image_map);
                        //  image_map.setOnTouchListener(new ImageMatrixTouchHandler(context));
                    }
                    catch (Exception e) {

                    }

                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            j=j+90;
                            image_map.setRotation ((float) j);

                        }
                    });


                    image_full.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {







                            final Dialog dialog = new Dialog(context);
                            dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog.setContentView(R.layout.custom_dialog_image_cedit_full);

                            int width = ViewGroup.LayoutParams.MATCH_PARENT;
                            int height = ViewGroup.LayoutParams.MATCH_PARENT;
                            dialog.getWindow().setLayout(width, height);
                            dialog.getWindow().setWindowAnimations(R.style.FullScreenDialogStyle);

                            dialog.setCancelable(true);
                            final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                            final ImageView image_remove=(ImageView)dialog.findViewById(R.id.image_remove);
                            final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);

                            rotage2.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    k=k+90;
                                    image_map.setRotation((float) k);

                                }
                            });
                            image_remove.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            try {
                                Glide.with(context).load(urls[position])

                                        .placeholder(context.getResources().getDrawable(R.drawable.no_image))

                                        .into(image_map);




                            }
                            catch (Exception e) {

                            }



                            dialog.show();
                        }
                    });

                    dialog.show();

                }

                else if(position == 2){


                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                    final ImageView image_full=(ImageView)dialog.findViewById(R.id.image_remove);
                    try {
                        Glide.with(context).load(urls[position])

                                .placeholder(context.getResources().getDrawable(R.drawable.no_image))
                                .into(image_map);
                        //  image_map.setOnTouchListener(new ImageMatrixTouchHandler(context));
                    }
                    catch (Exception e) {

                    }

                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            z=z+90;
                            image_map.setRotation ((float) z);

                        }
                    });



                    image_full.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {







                            final Dialog dialog = new Dialog(context);
                            dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog.setContentView(R.layout.custom_dialog_image_cedit_full);

                            int width = ViewGroup.LayoutParams.MATCH_PARENT;
                            int height = ViewGroup.LayoutParams.MATCH_PARENT;
                            dialog.getWindow().setLayout(width, height);
                            dialog.getWindow().setWindowAnimations(R.style.FullScreenDialogStyle);

                            dialog.setCancelable(true);
                            final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                            final ImageView image_remove=(ImageView)dialog.findViewById(R.id.image_remove);
                            final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);

                            rotage2.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    k=k+90;
                                    image_map.setRotation((float) k);

                                }
                            });
                            image_remove.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            try {
                                Glide.with(context).load(urls[position])

                                        .placeholder(context.getResources().getDrawable(R.drawable.no_image))

                                        .into(image_map);




                            }
                            catch (Exception e) {

                            }



                            dialog.show();
                        }
                    });

                    dialog.show();

                }

                else if(position == 3){


                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                    final ImageView image_full=(ImageView)dialog.findViewById(R.id.image_remove);
                    try {
                        Glide.with(context).load(urls[position])

                                .placeholder(context.getResources().getDrawable(R.drawable.no_image))
                                .into(image_map);
                        //  image_map.setOnTouchListener(new ImageMatrixTouchHandler(context));
                    }
                    catch (Exception e) {

                    }

                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            y=y+90;
                            image_map.setRotation ((float) y);

                        }
                    });


                    image_full.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {







                            final Dialog dialog = new Dialog(context);
                            dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog.setContentView(R.layout.custom_dialog_image_cedit_full);

                            int width = ViewGroup.LayoutParams.MATCH_PARENT;
                            int height = ViewGroup.LayoutParams.MATCH_PARENT;
                            dialog.getWindow().setLayout(width, height);
                            dialog.getWindow().setWindowAnimations(R.style.FullScreenDialogStyle);

                            dialog.setCancelable(true);
                            final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                            final ImageView image_remove=(ImageView)dialog.findViewById(R.id.image_remove);
                            final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);

                            rotage2.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    k=k+90;
                                    image_map.setRotation((float) k);

                                }
                            });
                            image_remove.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            try {
                                Glide.with(context).load(urls[position])

                                        .placeholder(context.getResources().getDrawable(R.drawable.no_image))

                                        .into(image_map);




                            }
                            catch (Exception e) {

                            }



                            dialog.show();
                        }
                    });

                    dialog.show();

                }

                else if(position == 4){


                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                    final ImageView image_full=(ImageView)dialog.findViewById(R.id.image_remove);
                    try {
                        Glide.with(context).load(urls[position])

                                .placeholder(context.getResources().getDrawable(R.drawable.no_image))
                                .into(image_map);
                        //  image_map.setOnTouchListener(new ImageMatrixTouchHandler(context));
                    }
                    catch (Exception e) {

                    }

                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            x=x+90;
                            image_map.setRotation ((float) x);

                        }
                    });

                    image_full.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {







                            final Dialog dialog = new Dialog(context);
                            dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog.setContentView(R.layout.custom_dialog_image_cedit_full);

                            int width = ViewGroup.LayoutParams.MATCH_PARENT;
                            int height = ViewGroup.LayoutParams.MATCH_PARENT;
                            dialog.getWindow().setLayout(width, height);
                            dialog.getWindow().setWindowAnimations(R.style.FullScreenDialogStyle);

                            dialog.setCancelable(true);
                            final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                            final ImageView image_remove=(ImageView)dialog.findViewById(R.id.image_remove);
                            final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);

                            rotage2.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    k=k+90;
                                    image_map.setRotation((float) k);

                                }
                            });
                            image_remove.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            try {
                                Glide.with(context).load(urls[position])

                                        .placeholder(context.getResources().getDrawable(R.drawable.no_image))

                                        .into(image_map);




                            }
                            catch (Exception e) {

                            }



                            dialog.show();
                        }
                    });

                    dialog.show();

                }
                else {


                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                    final ImageView image_full=(ImageView)dialog.findViewById(R.id.image_remove);
                    try {
                        Glide.with(context).load(urls[position])

                                .placeholder(context.getResources().getDrawable(R.drawable.no_image))
                                .into(image_map);
                        // image_map.setOnTouchListener(new ImageMatrixTouchHandler(context));
                    }
                    catch (Exception e) {

                    }

                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            k=k+90;
                            image_map.setRotation((float) k);

                        }
                    });


                    image_full.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {







                            final Dialog dialog = new Dialog(context);
                            dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog.setContentView(R.layout.custom_dialog_image_cedit_full);

                            int width = ViewGroup.LayoutParams.MATCH_PARENT;
                            int height = ViewGroup.LayoutParams.MATCH_PARENT;
                            dialog.getWindow().setLayout(width, height);
                            dialog.getWindow().setWindowAnimations(R.style.FullScreenDialogStyle);

                            dialog.setCancelable(true);
                            final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                            final ImageView image_remove=(ImageView)dialog.findViewById(R.id.image_remove);
                            final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);

                            rotage2.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    k=k+90;
                                    image_map.setRotation((float) k);

                                }
                            });
                            image_remove.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            try {
                                Glide.with(context).load(urls[position])

                                        .placeholder(context.getResources().getDrawable(R.drawable.no_image))

                                        .into(image_map);




                            }
                            catch (Exception e) {

                            }



                            dialog.show();
                        }
                    });


                    dialog.show();

                }














            }
        });




        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}