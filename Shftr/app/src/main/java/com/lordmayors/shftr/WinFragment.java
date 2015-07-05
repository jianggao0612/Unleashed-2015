package com.lordmayors.shftr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by andy on 5/07/15.
 */
public class WinFragment extends Fragment
{
    private GameState gameState;
    private View view;
    private MapsActivity winAckListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.win_menu, container, false);

        update();

        View btn = view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                winAckListener.winAcked();
            }
        });

        btn.setVisibility(View.GONE);

        return view;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;

        update();
    }

    private void update()
    {
        if( view != null && gameState != null) {
            LinearLayout scoreLayout = (LinearLayout) view.findViewById(R.id.score_layout);

            DecimalFormat two = new DecimalFormat("#0.00");

            TextView txtDistance = (TextView) scoreLayout.findViewById(R.id.distance);
            TextView txtCost = (TextView) scoreLayout.findViewById(R.id.cost);
            TextView txtCalories = (TextView) scoreLayout.findViewById(R.id.calories);
            TextView txtCo2 = (TextView) scoreLayout.findViewById(R.id.co2);
            TextView txtTotal = (TextView) scoreLayout.findViewById(R.id.total);

            txtDistance.setText("You travelled " + two.format(gameState.distance) + "m");
            txtCost.setText("You spent $" + two.format(gameState.getCash().getValue()));
            txtCalories.setText("You burnt " + two.format(gameState.getCalories().getValue()) + " calories!");
            txtCo2.setText("You emitted " + two.format(gameState.getCo2().getValue()) + " kg of CO2");
            txtTotal.setText("You scored " + two.format(gameState.getTotal()) + " points!!");
        }
    }
}
