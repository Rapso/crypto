
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



public class test {
    public static void start_test(List<Kryptogram> _kryptogramy) throws Exception {
        List <Integer> szyfry = new ArrayList <Integer>();// tab szyfrow
        int i,j;
        i = 0; j = 0;
        int kryptogramy[][] = new int [20][256];
        for ( i = 0; i < 20; i ++)	{
            for ( j = 0; j <_kryptogramy.get(i).length(); j++)
                kryptogramy[i][j] = _kryptogramy.get(i).znaki.get(j).znak_int;
        }

        System.out.print(kryptogramy[19][255]);
        for(i=0;i<256;i++)	{
            szyfry.add(SzukajSpacji(kryptogramy,i));
        }
        szyfry.set(0,130^76);
        szyfry.set(1,242^65);
        szyfry.set(4, 138^32);
        szyfry.set(11, 84^108);
        szyfry.set(14, 32^35);
        szyfry.set(19, 202^110);
        szyfry.set(21, 94^103);
        szyfry.set(22, 22^104);
        szyfry.set(35, 161^121);

        Dup(kryptogramy,szyfry);
    }
    static void Dup (int kryptogramy [][],List<Integer> list) throws IOException{ // wysylanie szukania spacji rezultatow do pliku
        System.out.println(Arrays.toString(list.toArray()));
        String fileOutput = "test.txt";
        int temp, i , j;
        FileOutputStream fos = new FileOutputStream(fileOutput);
        for(j=0;j<20;j++){
            fos.write(10);
            for(i=0;i<202;i++){
                if(list.get(i)!=-1) {
                    temp = kryptogramy[j][i] ^ list.get(i);
                }
                else
                    temp=32;
                fos.write(temp);

            }
            fos.write('\n');
        }
        fos.close();
    }

    static int SzukajSpacji(int krypto [][],int m){
        int result=0;
        int index=0;
        for(int i=0;i<20;i++){
            int temp=0;;
            for(int j=0;j<20;j++){

                if(((krypto[j][m]^krypto[i][m])<=127)&&((krypto[j][m]^krypto[i][m])>=64)){
                    temp++;
                }
            }
            if(temp>=10){
                index++;
                result=krypto[i][m]^32;
                break;
            }
        }
        if(index==0)
            return -1;
        return result;
    }
}