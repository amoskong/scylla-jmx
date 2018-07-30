/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copyright 2015 Cloudius Systems
 *
 * Modified by Cloudius Systems
 */

package org.apache.cassandra.net;

import java.net.UnknownHostException;
import java.util.Map;

/**
 * MBean exposing MessagingService metrics. - OutboundConnectionPools -
 * Command/Response - Pending/Completed Tasks
 */
public interface MessagingServiceMBean {
    /**
     * Pending tasks for large message TCP Connections
     */
    public Map<String, Integer> getLargeMessagePendingTasks();

    /**
     * Completed tasks for large message) TCP Connections
     */
    public Map<String, Long> getLargeMessageCompletedTasks();

    /**
     * Dropped tasks for large message TCP Connections
     */
    public Map<String, Long> getLargeMessageDroppedTasks();

    /**
     * Pending tasks for small message TCP Connections
     */
    public Map<String, Integer> getSmallMessagePendingTasks();

    /**
     * Completed tasks for small message TCP Connections
     */
    public Map<String, Long> getSmallMessageCompletedTasks();

    /**
     * Dropped tasks for small message TCP Connections
     */
    public Map<String, Long> getSmallMessageDroppedTasks();

    /**
     * Pending tasks for gossip message TCP Connections
     */
    public Map<String, Integer> getGossipMessagePendingTasks();

    /**
     * Completed tasks for gossip message TCP Connections
     */
    public Map<String, Long> getGossipMessageCompletedTasks();

    /**
     * Dropped tasks for gossip message TCP Connections
     */
    public Map<String, Long> getGossipMessageDroppedTasks();

    /**
     * Pending tasks for Command(Mutations, Read etc) TCP Connections
     */
    public Map<String, Integer> getCommandPendingTasks();

    /**
     * Completed tasks for Command(Mutations, Read etc) TCP Connections
     */
    public Map<String, Long> getCommandCompletedTasks();

    /**
     * Dropped tasks for Command(Mutations, Read etc) TCP Connections
     */
    public Map<String, Long> getCommandDroppedTasks();

    /**
     * Pending tasks for Response(GOSSIP & RESPONSE) TCP Connections
     */
    public Map<String, Integer> getResponsePendingTasks();

    /**
     * Completed tasks for Response(GOSSIP & RESPONSE) TCP Connections
     */
    public Map<String, Long> getResponseCompletedTasks();

    /**
     * dropped message counts for server lifetime
     */
    public Map<String, Integer> getDroppedMessages();

    /**
     * dropped message counts since last called
     */
    public Map<String, Integer> getRecentlyDroppedMessages();

    /**
     * Total number of timeouts happened on this node
     */
    public long getTotalTimeouts();

    /**
     * Number of timeouts per host
     */
    public Map<String, Long> getTimeoutsPerHost();

    /**
     * Back-pressure rate limiting per host
     */
    default public Map<String, Double> getBackPressurePerHost() {
        throw new UnsupportedOperationException();
    }

    /**
     * Enable/Disable back-pressure
     */
    default public void setBackPressureEnabled(boolean enabled) {
        throw new UnsupportedOperationException();
    }

    /**
     * Number of timeouts since last check.
     */
    public long getRecentTotalTimouts();

    /**
     * Number of timeouts since last check per host.
     */
    public Map<String, Long> getRecentTimeoutsPerHost();

    public int getVersion(String address) throws UnknownHostException;
}
