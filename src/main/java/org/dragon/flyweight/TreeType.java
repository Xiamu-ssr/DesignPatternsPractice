package org.dragon.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

/**
 * 树类型
 *
 * @author mumu
 * @date 2024/06/08
 */
@Getter
@AllArgsConstructor
public enum TreeType {
    PINE_TREE("松树", Color.GREEN, "松科（学名：Pinaceae）是松柏纲松柏目的一科，通称松、松树，尽管在汉语，其中不少种类称作“杉”，一般特点乃叶的形状像针，防止水分大量被蒸发。"),
    GINGKO("银杏", Color.ORANGE , "银杏（学名：Ginkgo biloba），落叶乔木，寿命可达3000年以上。又名公孙树、鸭掌树、鸭脚树、鸭脚子等，其裸露的种子称为白果，叶称蒲扇。"),
    RED_MAPLE("红枫", Color.RED, "红枫，槭树科槭属落叶小乔木，枝条多细长光滑，偏紫红色；叶掌状，裂片卵状披针形，先端尾状尖，缘有重锯齿；花顶生伞房花序，紫色；翅果，两翅间成钝角；");

    private String name;
    private Color color;
    private String otherTreeData;
}
