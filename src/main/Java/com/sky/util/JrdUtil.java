package com.sky.util;

import com.sky.model.Jrd;

import java.util.ArrayList;
import java.util.List;

//这是一个处理权限的工具类
public class JrdUtil {
    private static List<Jrd> all;//原始数据

    /**
     * 得到一个树形结构的方法
     * @param menuList
     * @return
     */
    public static List<Jrd> toTree(List<Jrd> menuList){
        all = menuList;
        //创建了一个装根节点的集合
        List<Jrd> roots = new ArrayList<>();
        //遍历原始数据集合  挑出所有的根节点
        for (Jrd menu:all){
            if(menu.getSpId()==0){
                roots.add(menu);
            }
        }
        //将根节点从原始集合中移除
        all.removeAll(roots);

        //设置子节点集合
        for (Jrd root:roots){
            //查找子节点并赋值
            root.setChildren(getCurrentChildren(root));
        }

        return roots;
    }

    //得到一个节点的子节点的方法
    private static List<Jrd> getCurrentChildren(Jrd menu){
        List<Jrd> children = new ArrayList<>();
        for (Jrd child:all){
            if(menu.getJrdId()==child.getSpId()){
                children.add(child);
            }
        }
        all.removeAll(children);

        //得到所有子节点的子节点集合
        for (Jrd child:children){
            child.setChildren(getCurrentChildren(child));
        }

        return children;
    }


}
