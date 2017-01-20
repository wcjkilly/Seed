package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PSOTest {
	
	int n=2; //���Ӹ���������Ϊ�˷�����ʾ������ֻȡ�������۲����˶�����  
    double[] y;  
    double[] x;  
    double[] v;  
    double c1=2;  
    double c2=2;  
    double pbest[];  
    double gbest;  
    double vmax=0.1;  
    public void fitnessFunction(){//��Ӧ����  
        for(int i=0;i<n;i++){  
            y[i]=-1*x[i]*(x[i]-2);  
        }  
    }  
    public void init(){ //��ʼ��  
        x=new double[n];  
        v=new double[n];  
        y=new double[n];  
        pbest=new double[n];  
        /*** 
         * ������Ӧ����������ģ�Ϊ�˷�����ʾ���������ֶ�����������㣬�ֱ��������ֵ���� 
         */  
        x[0]=-0.5;  
        x[1]=2.6;  
        v[0]=0.01;  
        v[1]=0.02;  
        fitnessFunction();  
        //��ʼ����ǰ���弫ֵ�����ҵ�Ⱥ�弫ֵ  
        for(int i=0;i<n;i++){  
            pbest[i]=y[i];  
            if(y[i]>gbest) gbest=y[i];  
        }  
        System.out.println("start gbest:"+gbest);  
    }  
    public double getMAX(double a,double b){  
        return a>b?a:b;  
    }  
    //����Ⱥ�㷨  
    public void PSO(int max){  
        for(int i=0;i<max;i++){  
            double w=0.4;  
            for(int j=0;j<n;j++){  
                //����λ�ú��ٶ�  
                v[j]=w*v[j]+c1*Math.random()*(pbest[j]-x[j])+c2*Math.random()*(gbest-x[j]);  
                if(v[j]>vmax) v[j]=vmax;  
                x[j]+=v[j];  
                //Խ���ж�  
                if(x[j]>2) x[j]=2;  
                if(x[j]<-2) x[j]=-2;  
                  
            }  
            fitnessFunction();  
            //���¸��弫ֵ��Ⱥ�弫ֵ  
            for(int j=0;j<n;j++){  
                pbest[j]=getMAX(y[j],pbest[j]);  
                if(pbest[j]>gbest) gbest=pbest[j];  
                System.out.println(x[j]+"  "+v[j]);  
            }  
            System.out.println("======"+(i+1)+"======gbest:"+gbest);  
        }  
    }

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		PSOTest ts=new PSOTest();
        ts.init();  
        ts.PSO(100);
        try {
			Class.forName("org.postgresql.Driver");
	        Connection connection = null;
	        connection = DriverManager.getConnection(
	           "jdbc:postgresql://localhost:5432/mydb","postgres", "123456");
	        if(connection!=null){
	        	System.out.println("success");
	        	Statement st = connection.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM test");
	            while (rs.next()) {
	               System.out.print(rs.getString(1));
	               System.out.print("  ");
	               System.out.println(rs.getString(2));
	            }
	            rs.close();
	            st.close();
	        }
	        connection.close();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}

}
