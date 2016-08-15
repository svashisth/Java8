import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;

import org.apache.commons.lang.math.RandomUtils;

public class A_VanyaAndFence
{
	public static void main(String args[]) throws IOException, InterruptedException
	{
		List<Callable<Long>> callables=new ArrayList<>();
		List<Callable<Long>> callables1=new LinkedList<>();
		
		long start = System.currentTimeMillis();
//		streamWrite();
		
		new Runnable()
		{
			
			@Override
			public void run()
			{
				int[] a = new int[1000*1000*1000];
				int[] a1 = new int[1000*1000*1000];
				int[] a2 = new int[1000*1000*1000];
				int[] a3 = new int[1000*1000*1000];
				
				for(int i = 0; i<1000*1000*1000; i++){
					a[i] = RandomUtils.nextInt();
				}
				for(int i = 0; i<1000*1000*1000; i++){
					a1[i] = RandomUtils.nextInt();
				}
				for(int i = 0; i<1000*1000*1000; i++){
					a2[i] = RandomUtils.nextInt();
				}
				for(int i = 0; i<1000*1000*1000; i++){
					a3[i] = RandomUtils.nextInt();
				}				
			}
		}.run();
		
		System.out.println("main\t" + (System.currentTimeMillis() - start) + " ms");
	}

	private static void streamWrite() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, h;
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		br.close();
	}
}
