package id1212.androidhangman.service;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {

        // New token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        // Displaying token
        Log.d("TOKEN: ", refreshedToken);

    }

}
