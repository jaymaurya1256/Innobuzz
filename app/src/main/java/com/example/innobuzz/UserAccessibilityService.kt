package com.example.innobuzz
import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast

class UserAccessibilityService : AccessibilityService() {

    override fun onServiceConnected() {
        // Set up your service
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

        if (event?.packageName?.toString() == "com.whatsapp") {

            Toast.makeText(applicationContext, "WhatsApp Launched", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onInterrupt() {
        // Handle interruption
    }
}