package com.service;

import com.vo.child.Architect;
import com.vo.child.Engineer;
import com.vo.child.Manager;
import com.vo.parent.Employee;

public class EmployeeService {
	private Employee[] employees = null;
	private static EmployeeService employeeService = new EmployeeService();
	private final int MAX_EMPLOYEE = 100;
	private int eIdx = 0;
	
	private EmployeeService() {
		employees = new Employee[MAX_EMPLOYEE];
	}
	
	public static EmployeeService getInstance() {
		return employeeService;
	}
	
    public void addEmployee(Employee e) {
    	employees[eIdx++] = e;
    	System.out.println(e.getName() + " 추가 완료");
    }
    
    public void deleteEmployee(int empno) {
    	int target = 0;
    	Employee targetEmp = null;
    	for (Employee e : employees) {
    		if (e.getEmpno() == empno) {
    			targetEmp = e;
    			break;
    		}
    		target += 1;
    	}
    	
    	if (target == eIdx) {
    		System.out.println("해당 직원은 존재하지 않습니다.");
    		return;
    	}
    	
    	for (int i = target; i < eIdx; i++) {
    		if (employees[i] != null)
    			employees[i] = employees[i + 1];
    		else
    			break;
    	}
    	
    	System.out.println(targetEmp.getName() + " 삭제 완료");
    }
    
    public void increaseSalary(int percent, int bonus) {
    	for (Employee e : employees) {
    		if (e == null)
    			break;
    		double defaultSalary = e.getSalary();
    		e.changeSalary(defaultSalary * (100 + percent) / 100);
    		if (e instanceof Engineer) {
    			int defaultBonus = ((Engineer)e).getBonus();
    			((Engineer)e).setBonus(defaultBonus + bonus);
    		}
    	}
    	
    	System.out.println("직원의 월급이" + percent + "%, 엔지니어의 보너스가" + bonus + "달러 인상되었습니다.");
    }
    
    public void changeEmployeeInfo(Employee emp) {
    	for (Employee e : employees) {
    		if (e == null)
    			break;
    		if (e.getEmpno() == emp.getEmpno()) {
    			if (e instanceof Engineer) {
    				((Engineer) e).setBonus(((Engineer)emp).getBonus());
    				((Engineer) e).setTech(((Engineer)emp).getTech());    				
    			} else if (e instanceof Manager) {
    				((Manager) e).setDept(((Manager)emp).getDept(), ((Manager)emp).getDeptno());
    			} else if (e instanceof Architect) {
    				((Architect) e).setProject(((Architect)emp).getProject());
    				((Architect) e).setSupervision(((Architect)emp).getSupervision());
    			}
    			break;
    		}
    	}
    }
    
    public Employee[] getEmployee() {
        return employees;
    }

    
    public Employee getEmployee(int empno) {
        Employee result = null;
    	
    	for (Employee e : employees) {
    		if (e.getEmpno() == empno) {
    			result = e;
    			break;
    		}
        }
        
        return result;
    }

    public Employee[] getEmployee(String name) {
    	Employee[] result = null;
    	int count = 0;
    	
    	for (Employee e : employees) {
    		if (e == null)
    			break;
    		if (e.getName().equals(name)) {
    			count += 1;
    		}
        }
    	
    	if (count == 0) {
    		System.out.println("해당하는 직원이 존재하지 않습니다.");
    		return null;
    	}
    	
    	result = new Employee[count];
    	
    	int resultIdx = 0;
    	for (Employee e : employees) {
    		if (e.getName().equals(name)) {
    			result[resultIdx++] = e;
    			if (resultIdx >= count)
    				break;
    		}
        }
        
        return result;
    }

    public Employee findEmployeeMostBonus() {
    	Employee result = null;
    	int mostBonus = -9999;
    	
    	for (Employee e : employees) {
    		if (e instanceof Engineer) {
    			if (mostBonus < ((Engineer) e).getBonus()) {
    				result = e;
    				mostBonus = ((Engineer) e).getBonus();
    			}
    		}
    	}
    	
        return result;
    }

    public Employee[] findEmployeeDept(String deptName) {
    	Employee[] result = null;
    	int count = 0;
    	
    	for (Employee e : employees) {
    		if (e instanceof Manager) {
    			Manager em = (Manager)e;
        		if (em.getDept().equals(deptName)) {
        			count += 1;
        		}
    		}
        }
    	
    	if (count == 0) {
    		System.out.println("해당하는 직원이 존재하지 않습니다.");
    		return null;
    	}
    	
    	result = new Employee[count];
    	
    	int resultIdx = 0;
    	for (Employee e : employees) {
    		if (e instanceof Manager) {
    			Manager em = (Manager)e;
        		if (em.getDept().equals(deptName)) {
        			result[resultIdx++] = e;
        			if (resultIdx >= count)
        				break;
        		}
    		}
        }
        
        return result;
    }

    public Employee[] findEmployeeDept(int deptNo) {
    	Employee[] result = null;
    	int count = 0;
    	
    	for (Employee e : employees) {
    		if (e instanceof Manager) {
    			Manager em = (Manager)e;
        		if (em.getDeptno() ==  deptNo) {
        			count += 1;
        		}
    		}
        }
    	
    	if (count == 0) {
    		System.out.println("해당하는 직원이 존재하지 않습니다.");
    		return null;
    	}
    	
    	result = new Employee[count];
    	
    	int resultIdx = 0;
    	for (Employee e : employees) {
    		if (e instanceof Manager) {
    			Manager em = (Manager)e;
    			if (em.getDeptno() == deptNo) {
        			result[resultIdx++] = e;
        			if (resultIdx >= count)
        				break;
        		}
    		}
        }
        
        return result;
    }

    
    public Employee findEmployeeSupervisioned(Employee architect) {
    	Employee emp = null;
    	Architect ea = (Architect)architect;
    	
    	for (Employee e : employees) {
    		if (e == null)
    			break;
    		if (e instanceof Engineer) {
    			Engineer eg = (Engineer)e;
    			if (eg.getEmpno() == ea.getSupervision()) {
        			emp = eg;
        			break;
        		}
    		}
        }
    	
        return emp;
    }
    
    
    public Employee findEmployeeArchitect(Employee emp) {
    	Employee arch = null;
    	Engineer eg = (Engineer)emp;
    	
    	for (Employee e : employees) {
    		if (e == null)
    			break;
    		if (e instanceof Architect) {
    			Architect ea = (Architect)e;
    			if (eg.getEmpno() == ea.getSupervision()) {
    				arch = ea;
        			break;
        		}
    		}
        }
    	
        return arch;
    }
    
}
