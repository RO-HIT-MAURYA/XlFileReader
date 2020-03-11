package hum.hai.xlfilereader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("file_example.xls");
            Workbook wb=Workbook.getWorkbook(inputStream);
            Sheet s=wb.getSheet(0);
            int row=s.getRows();
            int col=s.getColumns();

            String xx="";
            for (int i=0;i<row;i++)
            {

                for(int c=0;c<col;c++)
                {
                    Cell z=s.getCell(c,i);
                    xx=xx+z.getContents();

                }

                xx=xx+"\n";
            }
            ((TextView)findViewById(R.id.textView)).setText(xx);
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
    }
}
