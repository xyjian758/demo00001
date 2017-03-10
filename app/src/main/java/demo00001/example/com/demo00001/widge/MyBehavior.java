package demo00001.example.com.demo00001.widge;

import android.support.design.widget.CoordinatorLayout;
import android.view.View;

/**
 * Created by DELL on 2017/2/7.
 */

public class MyBehavior extends CoordinatorLayout.Behavior {
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
