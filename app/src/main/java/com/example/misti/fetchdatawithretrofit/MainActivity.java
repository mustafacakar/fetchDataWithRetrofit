package com.example.misti.fetchdatawithretrofit;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.misti.fetchdatawithretrofit.Model.Ip;
import com.example.misti.fetchdatawithretrofit.Remote.IpService;

import org.w3c.dom.Text;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    IpService mService;
    TextView txtIp;
    Button btnGetIp;
    AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = Common.getIpService();

        btnGetIp = (Button) findViewById(R.id.btnGetIP);
        txtIp = (TextView) findViewById(R.id.txtIP);
        //dialog = new SpotsDialog(MainActivity.class);

        btnGetIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getIpAdress();
            }
        });

    }


    public void getIpAdress(){
        mService.getIp().enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                txtIp.setText(response.body().getIp());
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {
                Log.e("ERROR",t.getMessage());


            }
        });

    }
}
