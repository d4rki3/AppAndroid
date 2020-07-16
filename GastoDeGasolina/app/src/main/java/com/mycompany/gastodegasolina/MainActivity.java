package com.mycompany.gastodegasolina;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	public iniciarVar mIniciarVar = new iniciarVar();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		this.mIniciarVar.mValor = findViewById(R.id.Valor);
		this.mIniciarVar.mConsumo = findViewById(R.id.Consumo);
		this.mIniciarVar.mDistancia = findViewById(R.id.Distancia);
		this.mIniciarVar.mTotal = findViewById(R.id.Total);
	}

	public void onClickCalc(View v)
	{
		if (this.mIniciarVar.mValor.length() > 0 & this.mIniciarVar.mConsumo.length() > 0 & this.mIniciarVar.mDistancia.length() > 0)
		{
			Toast.makeText(this, "Dados calculado", Toast.LENGTH_LONG).show();

			try
			{
				Double varValor = Double.parseDouble(this.mIniciarVar.mValor.getText().toString());
				Double varConsumo = Double.parseDouble(this.mIniciarVar.mConsumo.getText().toString());
				Double varDistancia = Double.parseDouble(this.mIniciarVar.mDistancia.getText().toString());

				Double varTotal = (varValor * varDistancia) / varConsumo;
				String strTotal = String.valueOf(varTotal);
				
				if(varConsumo == 0){
					this.mIniciarVar.mTotal.setText("");
				}else{
					this.mIniciarVar.mTotal.setText(strTotal);
				}
			}
			catch (Exception x)
			{
				Toast.makeText(this, "Dados invalidos", Toast.LENGTH_LONG).show();
			}
		}else{
			Toast.makeText(this, "Dados invalidos", Toast.LENGTH_LONG).show();
		}

	}

	public void onClickLim(View v)
	{
		this.mIniciarVar.mValor.setText("");
		this.mIniciarVar.mConsumo.setText("");
		this.mIniciarVar.mDistancia.setText("");
		this.mIniciarVar.mTotal.setText("");
		Toast.makeText(this, "Limpar", Toast.LENGTH_LONG).show();
	}

	public void onClickSair(View v)
	{
		Toast.makeText(this, "Sair", Toast.LENGTH_LONG).show();
		finish();
	}

	public class iniciarVar
	{
		EditText mValor;
		EditText mConsumo;
		EditText mDistancia;
		TextView mTotal;
	}
}
