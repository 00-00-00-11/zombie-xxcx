/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  java.io.File
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.concurrent.ExecutorService
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.app.Activity;
import android.content.Context;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ae;
import com.adcolony.sdk.af;
import com.adcolony.sdk.am;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.j;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

class a {
    static boolean a;
    static boolean b;
    private static WeakReference<Activity> c;
    private static j d;

    static af a(String string, af af2, boolean bl) {
        a.a().o().a(string, af2);
        return af2;
    }

    static j a() {
        if (!a.b()) {
            if (a.d()) {
                d = new j();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a.c().getFilesDir().getAbsolutePath());
                stringBuilder.append("/adc3/AppInfo");
                JSONObject jSONObject = w.c(stringBuilder.toString());
                JSONArray jSONArray = w.g(jSONObject, "zoneIds");
                String string = w.b(jSONObject, "appId");
                AdColonyAppOptions adColonyAppOptions = new AdColonyAppOptions().a(string).a(w.a(jSONArray));
                d.a(adColonyAppOptions, false);
            } else {
                return new j();
            }
        }
        return d;
    }

    static void a(Activity activity) {
        if (activity == null) {
            c.clear();
            return;
        }
        c = new WeakReference((Object)activity);
    }

    static void a(final Activity activity, AdColonyAppOptions adColonyAppOptions, boolean bl) {
        a.a(activity);
        b = true;
        if (d == null) {
            d = new j();
            d.a(adColonyAppOptions, bl);
        } else {
            d.a(adColonyAppOptions);
        }
        ax.b.execute(new Runnable(){

            public void run() {
                d.a((Context)activity, null);
            }
        });
        y.c.b("Configuring AdColony");
        d.b(false);
        d.j().d(true);
        d.j().e(true);
        d.j().f(false);
        a.d.g = true;
        d.j().a(false);
    }

    static void a(String string, af af2) {
        a.a().o().a(string, af2);
    }

    static void a(String string, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = w.a();
        }
        w.a(jSONObject, "m_type", string);
        a.a().o().a(jSONObject);
    }

    static void b(String string, af af2) {
        a.a().o().b(string, af2);
    }

    static boolean b() {
        return d != null;
    }

    static Activity c() {
        return (Activity)c.get();
    }

    static boolean d() {
        return c != null && c.get() != null;
    }

    static boolean e() {
        return a;
    }

    static void f() {
        a.a().o().b();
    }

}

