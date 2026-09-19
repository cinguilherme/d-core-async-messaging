(ns d-core.schemas-test
  (:require [clojure.test :refer [deftest is testing]]
            [d-core.core.producers.common :as common-producer]
            [d-core.core.producers.protocol :as p]))

(deftest common-producer-enforces-topic-schema
  (testing "CommonProducer validates msg-map against topic canonical schema before delegating"
    (let [calls (atom [])
          delegate (reify p/Producer
                     (produce! [_ msg-map options]
                       (swap! calls conj {:msg msg-map :options options})
                       {:ok true}))
          routing {:topics {:t {:schema {:canonical [:map {:closed true} [:a :int]]
                                         :strictness :strict
                                         :id :t}}}
                   :publish {:t {:targets [{:producer :in-memory}]}}}
          producer (common-producer/->CommonProducer :in-memory {:in-memory delegate} routing nil nil)]
      (is (thrown? clojure.lang.ExceptionInfo
                   (p/produce! producer {:a 1 :extra "x"} {:topic :t})))
      (is (= [] @calls))
      (is (= {:ok true}
             (select-keys (p/produce! producer {:a 1} {:topic :t}) [:ok])))
      (is (= 1 (count @calls))))))
