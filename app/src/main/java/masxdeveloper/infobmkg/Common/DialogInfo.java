package masxdeveloper.infobmkg.Common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import masxdeveloper.infobmkg.R;

/**
 * Created by Masx Developer on 3/23/17.
 * https://masx-dev.blogspot.com
 */

public class DialogInfo {

    public static AlertDialog DialogPreview(Context ctx,String URL){

        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);

        View v = LayoutInflater.from(ctx).inflate(R.layout.dialog_image , null, false);
        final ImageView Preview = (ImageView) v.findViewById(R.id.InfoPreviewImage);
        final LinearLayout DialogParent = (LinearLayout) v.findViewById(R.id.dialogParent);
        builder.setView(v);

        final AlertDialog dialog = builder.create();

        Glide.with(ctx)
                .load(URL)
                .placeholder(R.drawable.ic_sync)
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        DialogParent.setVisibility(View.VISIBLE);
                        Preview.setImageDrawable(resource);
                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        super.onLoadFailed(e, errorDrawable);
                        dialog.dismiss();
                    }
                });


        if (dialog != null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        return dialog;
    }
}
