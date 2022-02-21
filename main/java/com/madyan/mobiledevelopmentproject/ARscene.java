package com.madyan.mobiledevelopmentproject;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.Anchor;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.Camera;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class ARscene extends AppCompatActivity {
    private ArFragment arFragment;
    private ModelRenderable modelRenderable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arscene);

        String furniture = getIntent().getStringExtra("FURNITURE_TITLE");

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        setUpModel(furniture);
        setUpPlane();
    }

    private void setUpModel(String furniture) {
        String objString;
        if(furniture.equals("Office Chair"))
        {
            objString = "officeChair3.sfb";
        }
        else if(furniture.equals("Book Shelf"))
        {
            objString = "3d-model.sfb";
        }
        else if(furniture.equals("King size bed"))
        {
            objString = "asian_bedroom_sets.sfb";
        }
        else
        {
            objString = "abciuppa_table_w_m_01.sfb";
        }
        ModelRenderable.builder().
                setSource(this, Uri.parse(objString))
                .build()
                .thenAccept(renderable -> modelRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this, "Model can't be loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
    }

    private void setUpPlane()
    {
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());
                createModel(anchorNode);
            }
        });
    }

    private void createModel(AnchorNode anchorNode)
    {
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        node.setParent(anchorNode);
        node.setRenderable(modelRenderable);
        node.select();
    }
}