package algorithm.assignment;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {
	
	static Integer[] tmp = new Integer[100005];
	
	public double closestPair(Point[] ps, int left, int right){
		double d = Double.MAX_VALUE;
		if(left == right)
			return d;
		if(left+1 == right)
			return dis(ps[left], ps[right]);
		int mid = (left+right)>>1;
		double d1 = closestPair(ps, left, mid);
		double d2 = closestPair(ps, mid+1, right);
		d = Math.min(d1,d2);
		
		int i,j,k=0;
		for(i = left; i <= right; i++){
			if(Math.abs(ps[mid].x-ps[i].x) <= d)
				tmp[k++] = i;
		}
		
		Arrays.sort(tmp,0,k,new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return ps[o1].y < ps[o2].y ? -1 : 1;
			}
		});
		
		for(i = 0; i < k; i++){
			for(j = i+1; j<k && ps[tmp[j]].y-ps[tmp[i]].y<d; j++){
				double d3 = dis(ps[tmp[i]],ps[tmp[j]]);
				if(d>d3)
					d = d3;
			}
		}
		return d;
	}
	
	private double dis(Point p1, Point p2){
		return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
	}

}

class Point{
	double x;
	double y;
	Point(double x, double y){
		this.x = x;
		this.y = y;
	}
}
