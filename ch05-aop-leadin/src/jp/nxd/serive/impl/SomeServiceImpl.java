package jp.nxd.serive.impl;

import jp.nxd.serive.SomeService;
import jp.nxd.util.ServiceTools;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        //ServiceTools.doLog();
        System.out.println("执行了dosome方法");
        //ServiceTools.doTrans();
    }

    @Override
    public void doOther() {
        //ServiceTools.doLog();
        System.out.println("执行了doother方法");
        //ServiceTools.doTrans();
    }
}
