//============================================================================
// Name        : Traffic.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : http://www.spoj.com/problems/TRAFFICN/
//============================================================================

#include <iostream>
#include<vector>
#include<array>
#include<string.h>
#include<queue>
#include<cstdio>
using namespace std;
typedef vector<long long> vll;
int n;
int m;
int k;
int s;
int t;

vector<pair<int, long long>> adjList[2][10002];
class edge {
public:
	int from;
	int to;
	long long w;
	edge(int f, int t, long long weight) {
		from = f;
		to = t;
		w = weight;
	}
};
vector<edge> klist;
vll dijkstra(int num, int s) {
	vll dist(n+1, 999999999);
	priority_queue<pair<long long ,int>, vector<pair<long long ,int>>, greater<pair<long long ,int>> > pq;
	dist[s] = 0;
	pq.push(make_pair(0, s));
	while (!pq.empty()) {
		pair<long long, int> temp = pq.top();
		pq.pop();
		if (temp.first == dist[temp.second]) {
			for (int i = 0; i < adjList[num][temp.second].size(); ++i) {
				pair<int, long long > t = adjList[num][temp.second][i];
				if (dist[t.first] > temp.first + t.second) {
					dist[t.first] = temp.first + t.second;
					pq.push(make_pair( dist[t.first], t.first));
				}
			}
		}
	}
	return dist;
}
long long path() {
	vll d1 = dijkstra(0, s);
	vll d2 = dijkstra(1, t);
	long long min = d1[t];
	for (int i = 0; i < k; ++i) {
		edge e = klist[i];
		long long path = d1[e.from] + d2[e.to] + e.w;
		if (min > path) {
			min = path;
		}
		path = d1[e.to] + d2[e.from] + e.w;
		if (min > path) {
			min = path;
		}
	}
	if (min == 999999999)
		return -1;
	return min;
}
int main() {
	int testCases = 0;
	scanf("%d", &testCases);
	vector<string> v;
	string input;
	int i = 0;
	while (i < testCases) {
		scanf("%d %d %d %d %d", &n, &m, &k, &s, &t);
		for (int i = 0; i < n + 1; ++i) {
			adjList[0][i].clear();
			adjList[1][i].clear();
		}
		int j = 0;
		while (j < m) {
			int from, to; long long w;
			scanf("%d %d %lld", &from, &to, &w);
			adjList[0][from].push_back(make_pair(to, w));
			adjList[1][to].push_back(make_pair(from, w));
			j++;
		}
		j = 0;
		klist.clear();
		while (j < k) {
			int from, to; long long  w;
			scanf("%d %d %lld", &from, &to, &w);
			klist.push_back(edge(from, to, w));
			j++;
		}
		long long answer = path();
		printf("%lld\n", answer);
		i++;
	}
	return 0;
}
