/*
 * Copyright 2006 Pavel Jbanov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gc.gwt.wysiwyg.test.client;

import com.gc.gwt.wysiwyg.client.fck.FCKEditor;
import com.gc.gwt.wysiwyg.client.fck.FCKEditorConfig;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Test implements EntryPoint {

  private RootPanel getRootPanel() {
    return RootPanel.get("gwtAppContainer");
  }

  public void onModuleLoad() {
    final FCKEditor editor = new FCKEditor(new FCKEditorConfig() {
      {
      }
    });
    
    editor.setHTML("<h1>Hello World</h1>");
    
    VerticalPanel vp = new VerticalPanel();
    vp.setWidth("100%");
    vp.add(editor);
    vp.add(new Button("set some other html", new ClickListener() {
      public void onClick(Widget sender) {
        editor.setHTML("<h1>Some other html.</h1>");
      }
    }));
    vp.add(new Button("get text", new ClickListener() {
      public void onClick(Widget sender) {
        Window.alert(editor.getHTML());
      }
    }));
    
    getRootPanel().add(vp);
  }
}
