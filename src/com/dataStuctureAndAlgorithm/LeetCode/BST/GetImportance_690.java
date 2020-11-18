package com.dataStuctureAndAlgorithm.LeetCode.BST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*       690. 员工的重要性
*           给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度和 直系下属的id。
*           比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，
*           员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，
*           因此没有体现在员工1的数据结构中。
*
* */
public class GetImportance_690 {
	//递归
	int importance = 0;
	public int getImportance(List<Employee> employees, int id) {
		if(employees.isEmpty()) return 0;
		//创建Map存放ID和对应的Employee
		Map<Integer, Employee> map = new HashMap<>();
		for(Employee employee : employees) map.put(employee.id, employee);
		//调用递归函数
		getImportance(map,  id);
		return importance;
	}
	public void getImportance(Map<Integer, Employee> map, int id){
		//获取当前的Employee
		Employee cur = map.get(id);
		importance += cur.importance;
		if(cur.subordinates.isEmpty()) return;
		//遍历当前Employee的所有下属节点
		for(Integer subId : cur.subordinates){
			getImportance(map, subId);
		}
	}

    /*
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees) map.put(employee.id, employee);
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int result = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Employee cur = queue.poll();
                //判断是否到达终点
                result += cur.importance;
                //将当前节点的所有子节点放入队列
                for(Integer subId : cur.subordinates){
                    queue.offer(map.get(subId));
                }
        
            }
        }
        return result;
    }
    */
}

class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
};
